import React from 'react'

const JobCard = ({job}) => {
  let handleClick = () => {
    console.log("Applying for job id: ", job.id);
  }
  return (
    <div className='job-card'>
      <h1>{job.title}</h1>
      <h1>{job.company}</h1>
      <h1>{job.location}</h1>
      <button onClick={handleClick}>Apply</button>
    </div>
  )
}

export default JobCard