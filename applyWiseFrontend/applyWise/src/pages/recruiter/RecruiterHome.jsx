import React from 'react'

const RecruiterHome = () => {
  return (
    <div>
        <h1 className='text-3xl font-bold text-gray-800 mb-4'>Welcome to your Recruiter Dashboard</h1>
        <p className='text-gray-600 mb-6'>Here you can manage your job postings, review applications, and stay updated with the latest recruitment activities.</p>
        <div className='grid grid-cols-1 md:grid-cols-2 gap-6'>
            <div className='bg-white rounded-lg shadow-lg p-6'>
                <h2 className='text-xl font-semibold text-gray-800 mb-3'>Manage Job Postings</h2>
                <p className='text-gray-600 mb-4'>Create new job listings, update existing ones, and keep your job postings organized.</p>
                <a href="/recruiter/dashboard/add-job" className='text-blue-600 hover:text-blue-800 font-medium'>Add New Job</a>
            </div>
            <div className='bg-white rounded-lg shadow-lg p-6'>
                <h2 className='text-xl font-semibold text-gray-800 mb-3'>Review Applications</h2>
                <p className='text-gray-600 mb-4'>View and manage applications submitted by candidates for your job postings.</p>      
                <a href="/recruiter/dashboard/applications" className='text-blue-600 hover:text-blue-800 font-medium'>View Applications</a>
            </div>
        </div>  
    </div>
  )
}

export default RecruiterHome