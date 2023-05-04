import React from 'react'
import "bootstrap/dist/css/bootstrap.min.css"
import { useState,useEffect } from 'react'
import { useNavigate } from 'react-router-dom';

const Modal2 = ({setModal2}) => {

   const [users, setUser]=useState([]);
 
  
  //   let navigate = useNavigate();

 

    const getthing = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setUser(values => ({ ...values, [name]: value }))
    }
  
    const addmethod = () => {
     
        let takevalue = JSON.stringify(users);
        
        fetch("http://localhost:8080/api/user", {
            method: 'Post',
            headers: { 'Content-type': 'application/json' },
            body: takevalue
        }).then(r => { console.log(r.json()) })

        
  

     }  

  return (
    <div className='backshadow'>
     <div className='custom-modal'>

     <div className='delete-icon'
     onClick={()=>setModal2(false)}>X</div>

     <h2>Registration Form</h2>
     <form className='form-group' onSubmit={addmethod}>
     <input class="text" type="text" name="username" placeholder="Username" required="" value={users.username || ""} onChange={getthing}/>

        <br></br><br></br>
        <input class="text" type="text" name="password" placeholder="Password" required="" value={users.password || ""} onChange={getthing}/>
        <br></br><br></br>
        <input class="text" type="text" name="email" placeholder="Email" required="" value={users.email || ""} onChange={getthing}/>
        <br></br><br></br>
        <input class="text" type="text" name="fname" placeholder="First Name" required="" value={users.fname || ""} onChange={getthing}/>
        <br></br><br></br>
        <input class="text" type="text" name="lname" placeholder="Last Name" required="" value={users.lname || ""} onChange={getthing}/>
        <br></br><br></br>
        <input class="text" type="tel" name="mobilenumber" placeholder="Mobile Number" required="" value={users.mobilenumber || ""} onChange={getthing}/>
        <br></br><br></br>
        <input class="text" type="text" name="address" placeholder="Address" required="" value={users.address || ""} onChange={getthing}/>
        <br></br><br></br>
        <input class="text" type="text" name="cardholder" placeholder="Card holder" required="" value={users.cardholder || ""} onChange={getthing}/>
        <br></br><br></br>
        <input class="text" type="text" name="points" placeholder="Point" required="" value={users.points || ""} onChange={getthing}/>
        <br></br><br></br>
       
        <button type="submit" className='btn btn-success btn-md'>
            Register
        </button>       
     </form>
    </div>
    </div>
  );
}

export default Modal2;
