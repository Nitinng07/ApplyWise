import { Outlet } from "react-router-dom";
import Navbar from "../../components/Navbar";
import UserNav from "./UserNav";

function UserDashboard(){

  return(

    <>
      <UserNav></UserNav>
      <div className="min-h-screen bg-gradient-to-br from-blue-50 to-indigo-100">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-12">

          <div className="bg-white rounded-lg shadow-lg p-6">
            <Outlet></Outlet>
          </div>

        </div>
      </div>
    </>

  );

}

export default UserDashboard;