import React, { useState, useContext, useEffect } from "react";
import { GlobalContext } from "./Context/GlobalContext";
import { useNavigate } from "react-router-dom";

export const Signup = () => {
  const [firstname, setFirstname] = useState("");
  const [lastname, setLastname] = useState("");
  const [email, setEmail] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const { signup } = useContext(GlobalContext);

  const navigate = useNavigate();
  const handleSubmit = e => {
    e.preventDefault();
    fetch("http://localhost:8080/ggcritics/reg", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        firstName: firstname,
        lastName: lastname,
        email: email,
        username: username,
        password: password,
      }),
    })
      .then(res => res.json())
      .then(user => {
        if (user) {
          console.log(user);
          signup(user);
          navigate("/");
        } else {
          setFirstname("");
          setLastname("");
          setEmail("");
          setUsername("");
          setPassword("");
        }
      });
  };
  return (
    <div className="form-div">
      <h1 className="form-title">Signup</h1>
      <form onSubmit={handleSubmit}>
        <label>First Name:</label>
        <input
          className="form-input"
          type="firstname"
          id="firstname"
          value={firstname}
          onChange={e => setFirstname(e.target.value)}
        />
        <br />
        <label>Last Name:</label>
        <input
          className="form-input"
          type="lastname"
          id="lastname"
          value={lastname}
          onChange={e => setLastname(e.target.value)}
        />
        <br />
        <label>Email:</label>
        <input
          className="form-input"
          type="email"
          id="email"
          value={email}
          onChange={e => setEmail(e.target.value)}
        />
        <br />
        <label>username:</label>
        <input
          className="form-input"
          type="username"
          id="username"
          value={username}
          onChange={e => setUsername(e.target.value)}
        />
        <br />
        <label>Password:</label>
        <input
          className="form-input"
          type="password"
          id="password"
          value={password}
          onChange={e => setPassword(e.target.value)}
        />
        <br />
        <input className="form-input" type="submit" />
      </form>
    </div>
  );
};
