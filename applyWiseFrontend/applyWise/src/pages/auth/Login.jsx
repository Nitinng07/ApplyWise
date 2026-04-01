import { useState } from "react";
import api from "../../services/api";
import { jwtDecode } from "jwt-decode";
import { useNavigate } from "react-router-dom";
import Navbar from "../../components/Navbar";

function Login() {

  const [email,setEmail] = useState("");
  const [password,setPassword] = useState("");

  const navigate = useNavigate();

  const handleLogin = async (e) => {

    e.preventDefault();

    try {

      const res = await api.post("/auth/login",{
        email,
        password
      });

      const token = res.data.token;

      localStorage.setItem("token",token);

      const decoded = jwtDecode(token);
      
      const role = decoded.role;
      

      if(role === "JOB_SEEKER"){
        navigate("/user/dashboard");
      }

      if(role === "RECRUITER"){
        navigate("/recruiter/dashboard");
      }

      if(role === "ADMIN"){
        navigate("/admin/dashboard");
      }

    } catch(error){

      alert("Invalid credentials");

    }

  };

  return(

    <>
    <Navbar></Navbar>
      <div className="min-h-screen flex items-center justify-center bg-gray-100">

      <div className="bg-white p-8 rounded-xl shadow-lg w-96">

        <h2 className="text-2xl font-bold mb-6 text-center">
          Login
        </h2>

        <form onSubmit={handleLogin} className="space-y-4">

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

          <button
            className="w-full bg-blue-600 text-white p-2 rounded-lg"
          >
            Login
          </button>

        </form>

      </div>

    </div>
    </>

  );

}

export default Login;