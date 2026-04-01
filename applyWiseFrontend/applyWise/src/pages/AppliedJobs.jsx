import axios from 'axios';
import React, { useEffect } from 'react'

const AppliedJobs = () => {
    let [appliedJobs, setAppliedJobs] = React.useState([]);
    useEffect(() => {
        axios.get('http://localhost:8080/api/jobseeker/applied' ,  { headers: {
      Authorization: "Bearer " + localStorage.getItem("token")
    }
     } )
            .then(res => {
                setAppliedJobs(res.data);
                console.log(res.data);
            })
            .catch(err => console.log(err))
     } , [])
  return (
    <div className="flex flex-col gap-5 p-5 max-w-4xl mx-auto">
        {
            appliedJobs.map(data => (
                <div key={data.id} className="border border-gray-300 rounded-lg p-4 shadow-md bg-white hover:shadow-lg transition-shadow duration-300">
                    <h3 className="text-xl font-semibold text-gray-800 mb-3">Job ID: {data.job.id}</h3>
                    <p className="text-gray-700 mb-2"><strong>Title:</strong> {data.job.title}</p>
                    <p className="text-gray-700 mb-2"><strong>Description:</strong> {data.job.description}</p>
                    <p className="text-gray-700 mb-2"><strong>Location:</strong> {data.job.location}</p>
                    <p className="text-gray-700 mb-2"><strong>Salary:</strong> {data.job.minSal} - {data.job.maxSal}</p>
                    <p className="text-gray-700 mb-2"><strong>Company:</strong> {data.job.recruiter.companyName}</p>
                    <p className="text-gray-700 mb-2"><strong>Application Status:</strong> {data.applStatus}</p>    
                </div>
            ))
        }
    </div>
  )
}

export default AppliedJobs