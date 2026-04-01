import React from 'react'
import axios, {} from 'axios';

const AddJob = () => {

  let [state, setState] = React.useState({
    title: "",
  description: "",
  location: "",
  minSal: 0,
  maxSal: 0,
  jobType: "full-time",
  experience: 0
  }) ;
  let handleChange = (e)=>{
    setState({...state, [e.target.name]: e.target.value , experience : parseInt(state.experience)  ?? 0 });
  }

  let handleSubmit = (e) => {
    e.preventDefault()
    
    axios.post("http://localhost:8080/api/recruiter/jobs", state, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`
      }
    })
     .then((res) => {
      console.log(res);
      
        if(res.data == "JOB_ADDED"){
          alert('Job added successfully!');
        }else if(res.data == "JOB_ALREADY_EXISTS"){
          alert('Job already exists!');
        }else{
          alert('Failed to add job. Please try again.');
        }
        console.log(res.data);
     })
     .catch((err) => {
        console.error(err);
     });
  }
  
  return (
    <div>
      <h1 className='text-2xl font-bold mb-4'>Add Job</h1>
      <p className='text-gray-600'>This is the Add Job page. You can add new job listings here.</p>
      <form className='mt-4' onSubmit={handleSubmit}>
        <div className='mb-4'>
          <label className='block text-gray-700 text-sm font-bold mb-2' htmlFor='jobTitle'>
            Job Title
          </label>
          <input
            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline'
            name='title'
            type='text'
            placeholder='Enter job title'
            onChange={handleChange}
          />
        </div>
        <div className='mb-4'>
          <label className='block text-gray-700 text-sm font-bold mb-2' htmlFor='jobDescription'>
            Job Description
          </label>
          <textarea
            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline'
            name='description'
            placeholder='Enter job description'
            onChange={handleChange}
          ></textarea>
        </div>
        <div className='mb-4'>
          <label className='block text-gray-700 text-sm font-bold mb-2' htmlFor='jobLocation'>
            Job Location
          </label>
          <input
            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline'
            name='location'
            type='text'
            onChange={handleChange}
            placeholder='Enter job location'
          />
        </div>
        <div className='mb-4'>
          <label className='block text-gray-700 text-sm font-bold mb-2' htmlFor='salaryRange'>
            Min Salary
          </label>
          <input
            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline'
            name='minSal'
            type='number'
            onChange={handleChange}
            placeholder='Enter salary range'
          />
        </div>
        <div className='mb-4'>
          <label className='block text-gray-700 text-sm font-bold mb-2' htmlFor='salaryRange'>
            Max Salary
          </label>
          <input
            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline'
            name='maxSal'
            onChange={handleChange}
            type='number'
            placeholder='Enter salary range'
          />
        </div>
        <div className='mb-4'>
          <label className='block text-gray-700 text-sm font-bold mb-2' htmlFor='jobType'>
            Job Type
          </label>
          <select
            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline'
            name='jobType'
            onChange={handleChange}

          >
            <option value='full-time'>Full-Time</option>
            <option value='part-time'>Part-Time</option>
            <option value='contract'>Contract</option>
            <option value='internship'>Internship</option>
          </select>
        </div>
        <div className='mb-4'>
          <label className='block text-gray-700 text-sm font-bold mb-2' htmlFor='experienceLevel'>
            Experience Level
          </label>
          <input
            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline'
            name='experience'
            type='number'
            onChange={handleChange}
            placeholder='Enter experience level (e.g., Junior, Mid, Senior)'
          />  
        </div>
        <button
          className='bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline'
        >
          Add Job
        </button>
      </form>
    </div>
  )
}

export default AddJob