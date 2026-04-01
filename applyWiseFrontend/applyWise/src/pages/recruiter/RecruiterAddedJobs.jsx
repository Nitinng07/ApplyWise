import React from 'react'
import { useNavigate } from 'react-router-dom';

const RecruiterAddedJobs = () => {

  let [jobs, setJobs] = React.useState([]);
  let navigate = useNavigate() ; 

  React.useEffect(() => {
    fetch("http://localhost:8080/api/recruiter/getAddedJobs", {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`
      }
    })
     .then((res) => res.json())
     .then((data) => {
        setJobs(data);
     })
     .catch((err) => {
        console.error(err);
     });
  },[]) ;

  let handleView = (jobId) => {
    navigate(`/recruiter/dashboard/applications/${jobId}`);
  }

  return (
    <div>
      <h1>Added Jobs  </h1>
      <p>This is the Added Jobs page. You can view the jobs you have added here.</p>
      <div className='mt-4'>
        {
          jobs.length > 0 ? (
            jobs.map((job) => (
              <div key={job.id} className='border p-4 mb-4 rounded-lg shadow-md'>
                <h2 className='text-xl font-bold'>{job.title}</h2>
                <p className='text-gray-600'>{job.description}</p>
                <p className='text-gray-600'>Location: {job.location}</p>
                <p className='text-gray-600'>Salary: {job.minSal} - {job.maxSal}</p>
                <p className='text-gray-600'>Job Type: {job.jobType}</p>
                <p className='text-gray-600'>Experience: {job.experience} years</p>
                <p className='text-gray-600'>Posted on: {new Date(job.created_at).toLocaleDateString()}</p>
                <p className='text-gray-600'>Status: {job.is_active ? "Active" : "Inactive"}</p>
                <button className='mt-2 px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600' onClick={() => handleView(job.id)}>View Applications</button>
              </div>
            ))
          ) : (
            <p>No jobs added yet.</p>
          )
        }
      </div>
    </div>
  )
}

export default RecruiterAddedJobs