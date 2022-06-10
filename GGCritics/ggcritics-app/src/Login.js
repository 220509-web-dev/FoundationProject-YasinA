import React, { useState, useContext } from "react";
import { GlobalContext } from "./Context/GlobalContext";
import { useNavigate } from "react-router-dom";

export const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState("");
  const navigate = useNavigate();
  const { login } = useContext(GlobalContext);

  const handleSubmit = e => {
    e.preventDefault();
    fetch("http://localhost:8080/ggcritics/auth", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username: username,
        password: password,
      }),
    })
      .then(resp => resp.json())
      .then(user => {
        if (user) {
          console.log(user);
          navigate("/");
          login(user);
        } else {
          return alert("wrong Username or Password");
        }
      });
  };
  return (
    <div className="form-div">
      <div className="form-box">
        <h1 className="form-title">Login</h1>
        <form onSubmit={handleSubmit}>
          <label>username:</label>
          <input
            // className="form-input"
            type="username"
            id="username"
            value={username}
            onChange={e => setUsername(e.target.value)}
          />
          <br />
          <label>Password:</label>
          <input
            // className="form-input"
            type="password"
            id="password"
            value={password}
            onChange={e => setPassword(e.target.value)}
          />
          <br />
          <input className="form-input" type="submit" />
        </form>
      </div>
      {errors}
    </div>
  );
};
