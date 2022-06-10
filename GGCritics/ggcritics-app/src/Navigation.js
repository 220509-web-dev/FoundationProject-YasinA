import React, { useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { GlobalContext } from "./Context/GlobalContext";

export const Navigation = () => {
  const { logout, loggedIn } = useContext(GlobalContext);
  const navigate = useNavigate();

  if (loggedIn !== false) {
    const logoutUser = () => {
      fetch("/logout", {
        method: "DELETE",
        headers: {
          "Content-type": "application/json",
        },
      }).then(() => {
        logout();
        navigate("/login");
      });
    };

    return (
      <div className="nav-div">
        <nav>
          <Link to="/" className="nav">
            Home
          </Link>
          <button onClick={logoutUser} className="save">
            logout
          </button>
        </nav>
      </div>
    );
  } else {
    return (
      <div className="nav-div">
        <Link to="/" className="nav">
          Home
        </Link>
        <Link to="signup" className="nav">
          signup
        </Link>
        <Link to="login" className="nav">
          login
        </Link>
      </div>
    );
  }
};
