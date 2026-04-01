import React from 'react'

const UserHome = () => {
  return (
    <div>
        <h1 className='text-3xl font-bold text-gray-800 mb-4'>Welcome to Your Dashboard</h1>
        <p className='text-gray-600 mb-6'>Here you can explore job opportunities, manage your applications, and stay updated with the latest job postings.</p>
        <div className='grid grid-cols-1 md:grid-cols-2 gap-6'>
            <div className='bg-white rounded-lg shadow-lg p-6'>
                <h2 className='text-xl font-semibold text-gray-800 mb-3'>Explore Jobs</h2>
                <p className='text-gray-600 mb-4'>Browse through a wide range of job listings tailored to your preferences and qualifications.</p>
                <a href="/user/dashboard/jobs" className='text-blue-600 hover:text-blue-800 font-medium'>View Jobs</a>
            </div>
            <div className='bg-white rounded-lg shadow-lg p-6'>
                <h2 className='text-xl font-semibold text-gray-800 mb-3'>Manage Applications</h2>
                <p className='text-gray-600 mb-4'>Keep track of your job applications, view their status, and manage your submissions effectively.</p>      
                <a href="/user/dashboard/applied" className='text-blue-600 hover:text-blue-800 font-medium'>View Applied Jobs</a>
            </div>
        </div>      
        
    </div>
  )
}

export default UserHome