import { Outlet } from "react-router-dom";
import Navbar from "../../components/Navbar";
import RecruiterNav from "./RecruiterNav";

function RecruiterDashboard(){

  return(

    <>
      <RecruiterNav></RecruiterNav>
      <div className="p-6">

      <Outlet></Outlet>

    </div>
    </>

  );

}

export default RecruiterDashboard;