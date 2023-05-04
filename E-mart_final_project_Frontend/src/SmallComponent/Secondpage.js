import React from "react";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import Card from "../SmallComponent/Card";
import ProductCard from "../SmallComponent/ProductCard";

export function SecondPage(props) {
  const [products, setProduct] = useState([]);

  const { catMasterID } = useParams();
  useEffect(() => {
    fetch("http://localhost:4444/public/api/catmaster/suborproduct/" + catMasterID)
      .then((res) => res.json())
      .then((result) => {
        setProduct(result);
        console.log(result);
      });
  }, []);

  console.log("this checking");

  console.log(products);

  console.log("this checking");

  return (
    <div>
      <h1>Second Page new Heading</h1>
      <div className="container-fluid mb-5">
        <div className="row">
          <div className="col-12 mx-auto">
            <div className="row gt-4">
             {products.map((val)=>
             {
                if(val.flag == "M" || val.flag == "S")
                {
                  return (
                    <Card
                      imgsrc={val.catimagepath}
                      catname={val.catname}
                      id={val.catmasterid}
                      productid={val.productid}
                      flag={val.flag}
                    />
                  );
                }
                else{
                  return (
                    <ProductCard
                      imgsrc={val.catimagepath}
                      catname={val.catname}
                      id={val.catmasterid}
                      productid={val.productid}
                      flag={val.flag}
                      price={val.price}
                    />
                  );
                }

             })}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
