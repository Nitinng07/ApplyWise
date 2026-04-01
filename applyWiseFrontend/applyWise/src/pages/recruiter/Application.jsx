import React from 'react'

const Application = () => {
  let [applications, setApplications] = React.useState([]);
  let jobId = window.location.pathname.split("/").pop();

   React.useEffect(() => {
     fetch(`http://localhost:8080/api/recruiter/applications/${jobId}`, {
       headers: {
         Authorization: `Bearer ${localStorage.getItem("token")}`
       }
     })
      .then((res) => res.json())
      .then((data) => {
         setApplications(data);
         console.log(data);
         
      })
      .catch((err) => {
         console.error(err);  
      });
  },[]) ;


  return (
    <div>
      <h1>Application</h1>
      <p>This is the application page for recruiters.</p>
      <div className='mt-4'>
        {
          applications.length > 0 ? (
            applications.map((app) => (
              <div key={app.id} className='border p-4 mb-4 rounded-lg shadow-md'>
                <h2 className='text-xl font-bold'>{app.jobSeekers.id}</h2>
                <p className='text-gray-600'>Email: {app.jobSeekers.email}</p>
                <p className='text-gray-600'>Phone: {app.jobSeekers.name}</p>
                <p className='text-gray-600'>Resume: <a href={app.resume_url} target="_blank" rel="noopener noreferrer" className='text-blue-500 underline'>View Resume</a></p>
                <p className='text-gray-600'>Applied on: {new Date(app.jobSeekers.createdAt).toLocaleDateString()}</p>
              </div>
            ))
          ) : (
            <p>No applications found for this job.</p>
          )
        }
      </div>
    </div>
  )
}

export default Application