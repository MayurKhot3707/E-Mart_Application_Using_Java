import React from 'react';
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

export default function InsertToCart() {


   const { productId } = useParams();
    
    const [products, setProduct] = useState({});
    // const { productID,price } = products;

  useEffect(() => {
    fetch("https://localhost:7258/api/ProductMaster/"+productId)
      .then((res) => res.json())
      .then((result) => {
        setProduct(result);
      });
  }, {});
    //   let navigate = useNavigate();

  
    // const addmethod = () => {
     
        // let takevalue = JSON.stringify(users);
        
    //     fetch("https://localhost:7258/api/AddToCarts", {
    //         method: 'Post',
    //         headers: { 'Content-type': 'application/json' },
    //         body: takevalue
    //     }).then(r => { console.log(r.json())
    //       console.log(takevalue);  })
    //  }  

  return (
    <div>
      
    </div>
  )
}
