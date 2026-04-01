import React from 'react'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'

const Home = () => {
  return (
    <div>
      <Navbar></Navbar>
      <div className='text-center m-20 '>

          <h1 className='font-bold font-stretch-75% text-4xl'>Welcome to ApplyWise</h1>

          <h3 className='text-2xl'>Find your dream job</h3>
      </div>
      
      <Footer></Footer>
    </div>

  )
}

export default Home