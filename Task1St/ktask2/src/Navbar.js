import React from 'react';
import './Navbar.css'; 


const Navbar = () => {
  return (
    <div>
    <nav className='navbar navbar-expand bg-warning'>
      <ul className='navbar-nav ms-auto'>
      <div className='nav-item'><button className='btn btn-primary mx-2'>Home</button></div>
         <div className='nav-item'><button className='btn btn-primary' >services</button></div> 
        <div className='nav-item'><button className='btn btn-primary mx-2'>About</button></div> 
        <div className='nav-item'><button className='btn btn-primary' >contant us</button></div> 

      </ul>
    </nav>
    </div>
  );
};

export default Navbar;