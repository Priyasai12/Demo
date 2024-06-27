import React from 'react'

const Login = () => {
     
        return (
            <div>
                         
        <div className='d-flex justify-content-center flex-column align-items-center'>
          <h2>Login</h2>
          <form>
            <input
              type="email"
              placeholder="Username"
              />
              <br/>
            <input
              type="password"
              placeholder="Password"
              />
              <br/>
              
            <button type="submit">Login</button>
          </form>
        </div>
        </div>
      )
    }

export default Login