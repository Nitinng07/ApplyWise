import axios from "axios";
import React, { useEffect, useState } from "react";

const UserProfile = () => {
  const [user, setUser] = useState({});
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    location: "",
    education: "",
    experienceYears: "",
    skills: "",
    resumeUrl: "",
  });
  const [updateProfile, setUpdateProfile] = useState({
    user: {
      name: formData.name,
      email: formData.email,
    },
    location: formData.location,
    education: formData.education,
    experienceYears: formData.experienceYears,
    skills: formData.skills,
    resumeUrl: formData.resumeUrl,
  });

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const token = localStorage.getItem("token");
        const response = await axios.get(
          "http://localhost:8080/api/jobseeker/profile",
          {
            headers: {
              Authorization: `Bearer ${token}`,
            },
          },
        );
        console.log(response);
        setUser(response.data);
        setFormData({
          name: response.data.user.name || "",
          email: response.data.user.email || "",
          location: response.data.location || "",
          education: response.data.education || "",
          experienceYears: response.data.experienceYears || "",
          skills: response.data.skills || "",
          resumeUrl: response.data.resumeUrl || "",
        });
      } catch (error) {
        console.error("Error fetching user data:", error);
      }
    };

    fetchUserData();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const payload = {
      user: {
        name: formData.name,
        email: formData.email,
      },
      location: formData.location,
      education: formData.education,
      experienceYears: Number(formData.experienceYears),
      skills: formData.skills,
      resumeUrl: formData.resumeUrl,
    };
    try {
      const token = localStorage.getItem("token");
      console.log(formData);

      console.log(updateProfile);

      await axios
        .put("http://localhost:8080/api/jobseeker/profile", payload, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        })
        .then((response) => {
          console.log(response);
          setFormData({
            name: response.data.user.name || "",
            email: response.data.user.email || "",
            location: response.data.location || "",
            education: response.data.education || "",
            experienceYears: response.data.experienceYears || "",
            skills: response.data.skills || "",
            resumeUrl: response.data.resumeUrl || "",
          });
        });
      alert("Profile updated successfully");
    } catch (error) {
      console.error("Error updating profile:", error);
    }
  };

  return (
    <div>
      <h1 className="text-3xl font-bold mb-4">User Profile</h1>
      <form
        onSubmit={handleSubmit}
        className="bg-white shadow-md rounded-lg p-6"
      >
        <div className="mb-6">
          <h2 className="text-xl font-semibold mb-2">Personal Details</h2>
          <label className="block text-gray-700 mb-1">Name:</label>
          <input
            type="text"
            value={formData.name}
            onChange={(e) => setFormData({ ...formData, name: e.target.value })}
            className="border p-2 w-full mb-2"
          />
          <label className="block text-gray-700 mb-1">Email:</label>
          <input
            type="email"
            value={formData.email}
            onChange={(e) =>
              setFormData({ ...formData, email: e.target.value })
            }
            className="border p-2 w-full mb-2"
          />
          <label className="block text-gray-700 mb-1">Location:</label>
          <input
            type="text"
            value={formData.location}
            onChange={(e) =>
              setFormData({ ...formData, location: e.target.value })
            }
            className="border p-2 w-full mb-2"
          />
        </div>
        <div className="mb-6">
          <h2 className="text-xl font-semibold mb-2">Education</h2>
          <label className="block text-gray-700 mb-1">Education:</label>
          <input
            type="text"
            value={formData.education}
            onChange={(e) =>
              setFormData({ ...formData, education: e.target.value })
            }
            className="border p-2 w-full mb-2"
          />
        </div>
        <div className="mb-6">
          <h2 className="text-xl font-semibold mb-2">Experience & Skills</h2>
          <label className="block text-gray-700 mb-1">
            Experience (Years):
          </label>
          <input
            type="number"
            value={formData.experienceYears}
            onChange={(e) =>
              setFormData({ ...formData, experienceYears: e.target.value })
            }
            className="border p-2 w-full mb-2"
          />
          <label className="block text-gray-700 mb-1">Skills:</label>
          <input
            type="text"
            value={formData.skills}
            onChange={(e) =>
              setFormData({ ...formData, skills: e.target.value })
            }
            className="border p-2 w-full mb-2"
          />
        </div>
        <div className="mb-6">
          <h2 className="text-xl font-semibold mb-2">Resume</h2>
          <label className="block text-gray-700 mb-1">Resume URL:</label>
          <input
            type="text"
            value={formData.resumeUrl}
            onChange={(e) =>
              setFormData({ ...formData, resumeUrl: e.target.value })
            }
            className="border p-2 w-full mb-2 bg-gray-100"
          />
          {formData.resumeUrl && (
            <p className="text-gray-700 mb-2">
              View Resume:{" "}
              <a
                href={formData.resumeUrl}
                target="_blank"
                rel="noopener noreferrer"
                className="text-blue-600 hover:underline"
              >
                Click here
              </a>
            </p>
          )}
        </div>
        <button
          type="submit"
          className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        >
          Update Profile
        </button>
      </form>
    </div>
  );
};

export default UserProfile;
