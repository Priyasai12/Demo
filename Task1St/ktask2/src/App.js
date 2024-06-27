import logo from './logo.svg';
import './App.css';
import Header from './Header';
import Footer from './Footer';
import Navbar from './Navbar';
import Login from './Login';

function App() {
  return (
    <div className="App">
      <Header/>
      <Navbar/>
      <Login/>
      <Footer/>
      
    </div>
  );
}

export default App;
