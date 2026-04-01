import { useState } from "react";
import api from "../../services/api";
import { useNavigate } from "react-router-dom";
import Navbar from "../../components/Navbar";

function Register(){

  const [name,setName] = useState("");
  const [email,setEmail] = useState("");
  const [password,setPassword] = useState("");
  const [role,setRole] = useState("JOB_SEEKER");

  const navigate = useNavigate();

  const handleRegister = async(e)=>{

    e.preventDefault();

    try{

      await api.post("/auth/register",{
        name,
        email,
        password,
        role
      });

      alert("Registration Successful");

      navigate("/login");

    }
    catch(err){

      alert("Registration Failed");

    }

  };

  return(

    <>
      <Navbar></Navbar>
      <div className="min-h-screen flex items-center justify-center bg-gray-100">

      <div className="bg-white p-8 rounded-xl shadow-lg w-96">

        <h2 className="text-2xl font-bold mb-6 text-center">
          Register
        </h2>

        <form onSubmit={handleRegister} className="space-y-4">

          <input
            type="text"
            placeholder="Full Name"
            className="w-full border p-2 rounded-lg"
            value={name}
            onChange={(e)=>setName(e.target.value)}
          />

          <input
            type="email"
            placeholder="Email"
            className="w-full border p-2 rounded-lg"
            value={email}
            onChange={(e)=>setEmail(e.target.value)}
          />

          <input
            type="password"
            placeholder="Password"
            className="w-full border p-2 rounded-lg"
            value={password}
            onChange={(e)=>setPassword(e.target.value)}
          />

          <select
            className="w-full border p-2 rounded-lg"
            value={role}
            onChange={(e)=>setRole(e.target.value)}
          >
            <option value="JOB_SEEKER">Job Seeker</option>
            <option value="RECRUITER">Recruiter</option>
          </select>

          <button
            className="w-full bg-green-600 text-white p-2 rounded-lg"
          >
            Register
          </button>

        </form>

      </div>

    </div>
    </>

  );

}

export default Register;