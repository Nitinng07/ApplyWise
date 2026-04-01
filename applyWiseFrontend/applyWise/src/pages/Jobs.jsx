import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Jobs = () => {
  const [jobs, setJobs] = useState([]);
  const [loading, setLoading] = useState(true);
  const [appliedJobs, setAppliedJobs] = useState(new Set());
  let navigate = useNavigate();
  const token = localStorage.getItem("token");

  const config = {
    headers: {
      Authorization: "Bearer " + token,
    },
  };

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/jobseeker/jobs", config)
      .then((res) => {
        setJobs(res.data);
        setLoading(false);
      })
      .catch((err) => {
        console.log(err);
        setLoading(false);
      });
  }, []);

  let handleApply = (id) => {
    axios
      .post(`http://localhost:8080/api/jobseeker/apply/${id}`, {}, config)
      .then((res) => {
        if (res.data === "APPLIED_JOB") {
          alert("You have successfully applied for this job.");
        } else if (res.data === "ALREADY_APPLIED") {
          alert("You have already applied for this job.");
          return;
        }
        setAppliedJobs(new Set([...appliedJobs, id]));
      })
      .catch((err) => {
        if (err.response) {
          if (
            err.response.status === 403 &&
            err.response.data === "PROFILE_INCOMPLETE"
          ) {
            navigate("/user/dashboard/profile");
            alert("Please complete your profile before applying for jobs.");
            // navigate("/complete-profile");
          }
        } else {
          console.log("Network error", err);
        }
      });
  };

  if (loading) {
    return (
      <div className="flex items-center justify-center min-h-screen bg-gray-50">
        <div className="text-xl text-gray-600">Loading jobs...</div>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-gray-50 py-12 px-4 sm:px-6 lg:px-8">
      <div className="max-w-4xl mx-auto">
        <h2 className="text-3xl font-bold text-gray-900 mb-8">
          Available Jobs
        </h2>

        <div className="space-y-6">
          {jobs.length === 0 ? (
            <div className="bg-white rounded-lg shadow p-6 text-center">
              <p className="text-gray-600">No jobs available at the moment.</p>
            </div>
          ) : (
            jobs.map((job) => (
              <div
                key={job.id}
                className="bg-white rounded-lg shadow-md hover:shadow-lg transition-shadow duration-300 p-6"
              >
                <div className="flex flex-col sm:flex-row sm:justify-between sm:items-start gap-4">
                  <div className="flex-1">
                    <h3 className="text-xl font-semibold text-gray-900">
                      {job.title}
                    </h3>
                    <p className="text-gray-600 mt-2">{job.description}</p>
                    <p className="text-gray-500 mt-4 text-sm">
                      Location: {job.location}
                    </p>
                    <p className="text-gray-500 mt-2 text-sm">
                      Salary: {job.minSal} - {job.maxSal}
                    </p>
                    <p className="text-gray-500 mt-2 text-sm">
                      Experience Required: {job.experience} years
                    </p>
                    <p className="text-gray-500 mt-2 text-sm">
                      Skills Required: {job.skills}
                    </p>
                    <p className="text-gray-500 mt-2 text-sm">
                      Hiring Manage: {job.recruiter.name}
                    </p>
                    <p className="text-gray-500 mt-2 text-sm">
                      Hiring Manage: {job.recruiter.email}
                    </p>
                    <p
                      className="text-gray-500 mt-2 text-sm"
                      style={{
                        backgroundColor: job.is_active ? "green" : "red",
                        color: "white",
                        display: "inline-block",
                        padding: "2px 6px",
                        borderRadius: "4px",
                      }}
                    >
                      Is Active : {job.is_active ? "Yes" : "No"}
                    </p>
                  </div>

                  <button
                    onClick={() => handleApply(job.id)}
                    disabled={appliedJobs.has(job.id)}
                    className={`px-6 py-2 rounded-lg font-semibold transition-all duration-200 whitespace-nowrap ${
                      appliedJobs.has(job.id)
                        ? "bg-gray-300 text-gray-700 cursor-not-allowed"
                        : "bg-blue-600 text-white hover:bg-blue-700 active:scale-95"
                    }`}
                  >
                    {appliedJobs.has(job.id) ? "Applied" : "Apply"}
                  </button>
                </div>
              </div>
            ))
          )}
        </div>
      </div>
    </div>
  );
};

export default Jobs;
