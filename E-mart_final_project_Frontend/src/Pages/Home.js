import React from "react";
import { useState, useEffect } from "react";
import Card from "../SmallComponent/Card";
import { useNavigate, useParams } from "react-router-dom";
import { Outlet, Link } from "react-router-dom";
import Carousel from "../Component/Carousel";

import ProductCard from "../SmallComponent/ProductCard";
export default function Home() {
  const [products, setProduct] = useState([]);

  useEffect(() => {
    fetch("http://localhost:4444/public/api/catmaster/major")
      .then((res) => res.json())
      .then((result) => {
        setProduct(result);
        console.log(result);
      });
  }, []);

  const [dodproducts, setDodproduct] = useState([]);

  useEffect(() => {
    fetch("http://localhost:4444/public/api/catmaster/dod")
      .then((response) => response.json())
      .then((result) => {
        setDodproduct(result);
      });
  }, []);

  const [tspproducts, setTSPProduct] = useState([]);

  useEffect(() => {
    fetch("http://localhost:4444/public/api/catmaster/tsp")
    .then((response) => response.json())
    .then((result) => {
      setTSPProduct(result);
    });
  }, []);

  return (
    <div>
      <br />
      <Carousel />
      <br />

      <div className="container-fluid mb-5">
        <div className="row">
          <div className="col-12 mx-auto">
            <div className="row gt-4">
              <div className="container-fluid mb-5">
                <div className="row">
                  <div className="col-12 mx-auto">
                    <h3 className="h3">categories</h3>
                    <div className="row gt-4">
                      {products.map((val, ind) => {
                        return (
                          <Card
                            imgsrc={val.catimagpath}
                            catname={val.catname}
                            id={val.catmasterid}
                            productid={val.productid}
                            flag={val.flag}
                          />
                        );
                      })}
                    </div>
                  </div>
                </div>
              </div>
              <h3 className="h3">deal of the day</h3>
              <div className="row gt-4">
                {dodproducts.map((val) => {
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
                })}
              </div>
            </div>
          </div>
        </div>
      </div>
      <hr />

      <div className="container-fluid mb-5">
        <div className="row">
          <div className="col-12 mx-auto">
            <h3 className="h3">top picks</h3>
            <div className="row gt-4">
            {tspproducts.map((val) => {
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
                })}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
