import React, { useState, useEffect } from "react";

const GlobalContext = React.createContext();

function ContextProvider({ children }) {
  const [user, setUser] = useState(null);
  const [loggedIn, setLoggedIn] = useState(false);
  useEffect(() => {
    fetch("/me")
      .then(res => res.json())
      .then(data => {
        if (data != null) {
          console.log(data);
          setUser(data);
          setLoggedIn(true);
        }
      });
  }, []);

  const login = user => {
    setUser(user);
    setLoggedIn(true);
  };

  const logout = () => {
    setUser(null);
    setLoggedIn(false);
  };

  const signup = user => {
    setUser(user);
    setLoggedIn(true);
  };

  return (
    <GlobalContext.Provider
      value={{
        user,
        login,
        logout,
        signup,
        loggedIn,
      }}
    >
      {children}
    </GlobalContext.Provider>
  );
}

export { GlobalContext, ContextProvider };
