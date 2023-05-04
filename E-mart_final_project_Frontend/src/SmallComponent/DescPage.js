import React from "react";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import "./DescPage.css";
import Modal1 from "../SmallComponent/Modal1";
import Modal2 from "../SmallComponent/Modal2";
import Button from "../SmallComponent/Button";

export default function DescPage(props) {
  const [products, setProduct] = useState([]);
  const [myObject, setMyObject] = useState({});
  const [modal1, setModal1] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogout = () => {
    // Remove user data from session storage
    sessionStorage.removeItem("userData");
    setIsLoggedIn(false);
  };

  useEffect(() => {
    const storedObject = sessionStorage.getItem("userData");
    if (storedObject) {
      setMyObject(JSON.parse(storedObject));
    }
  }, []);

  const { productID } = useParams();
  useEffect(() => {
    fetch(
      "http://localhost:4444/public/api/productmaster/productdesc/" + productID
    )
      .then((res) => res.json())
      .then((result) => {
        setProduct(result);
        //console.log(result);
      });
  }, []);

  const [isPopupOpen, setIsPopupOpen] = useState(false);

  const showPopup = () => {
    setIsPopupOpen(true);
    setTimeout(() => {
      setIsPopupOpen(false);
    }, 5000); // Change 5000 to the number of milliseconds you want the popup to show for
  };

  const [clickCount, setClickCount] = useState(1);

  function handleClick() {
    console.log(clickCount);
    setClickCount(clickCount + 1);
    if (clickCount == 1) {
      InsertToCartMethod();
    } else {
      SecondMethodUpdate();
    }
  }

  const SecondMethodUpdate = () => {
    // alert(0);
  };

  const method = () => {
    handleClick();
    // if (sessionStorage.getItem("userData") == null) {
    //   alert("Please Login First");
    // } else {
    //   alert("Your Item is Added To Cart");
    //   handleClick();
    //   showPopup();
    // }
  };

  const cartobject = {
    price: products.price,
    cardholderprice: products.cardholderprice,
    qty: 1,
    discount: products.discount,
    pointredm: products.pointredm,
    productid: products.productid,
    productimage: products.productimagpath,
    productshortdesc: products.productshortdesc,
    productname: products.productname,
  };

  const InsertToCartMethod = () => {
    let takevalue = JSON.stringify(cartobject);

    fetch("http://localhost:8080/api/addtocart", {
      method: "Post",
      headers: { "Content-type": "application", "Autherization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqeW90aSIsImV4cCI6MTY4MTU4MTUzOSwiaWF0IjoxNjgxNTYzNTM5fQ.vHhJzcjzK2SvrGf5XhZXAk__HlBE-yU1Fgl2i0VbHLD3O2FzSKSwUW4iMNnUnONeXZlu77GhM_Zzh74sSVyzsw"
    },
      body: takevalue,
    }).then((r) => {
      console.log(r.json());
    });
    // const [isAdded, setIsAdded] = useState(false);

    // function handleClick() {
    //   if (!isAdded) {
    // {
    //   products.map((val) => {
    //     if (val.pt.configID === 1) {
    //       const InsertToCart = {
    //         productID: val.p.productID,
    //         price: val.p.price,
    //         discount: val.p.discount,
    //         cardHolderPrice: val.p.cardHolderPrice,
    //         pointRedm: val.p.pointRedm,
    //         qty: 1,
    //         productImage: val.p.productImage,
    //         productShortDesc: val.p.productShortDescription,
    //         productName: val.p.productName,
    //       };
    //       console.log(InsertToCart);
    //       let takevalue = JSON.stringify(InsertToCart);

    //       fetch("https://localhost:7030/api/AddToCarts", {
    //         method: "Post",
    //         headers: { "Content-type": "application/json" },
    //         body: takevalue,
    //       }).then((r) => {
    //         console.log(r.json());
    //       });
    //       //   setIsAdded(true);
    //     }
    //   });
    //   // }
    //   // }
    // }
  };

  const checklogin = () => {
    if (myObject.userName == null) {
      // {isLoggedIn ? (
      //   <button
      //     className="btn btn-primary btn-md mx-2"
      //     onClick={handleLogout}
      //   >
      //     Logout
      //   </button>
      // ) : (
      //   <Button setModal1={setModal1} />
      // )}
      {
        modal1 === true && (
          <Modal1 setModal1={setModal1} setIsLoggedIn={setIsLoggedIn} />
        );
      }
    }
  };

  return (
    <div className="container class_border">
      <div className="row my-5">
        <div className="col-sm-4">
          {/* <img src={products.productimagpath} width="350" height="350" /> */}
          {products.map((val) => {
            if (val.configid === 1) {
              return <img src={val.productimagpath} width="350" height="350" />;
            }
          })}
        </div>

        <div className="col-sm-5">
          {/* <h3>{products.productshortdesc}</h3> */}
          {products.map((val) => {
            if (val.configid === 1) {
              return <h3>{val.productshortdesc}</h3>;
            }
          })}
          <hr />

          <h4>
            <label>
              <span>M.R.P : </span> <sup>₹</sup>
              {/* <b>{products.price}</b> */}
              {products.map((val) => {
                if (val.configid === 1) {
                  return <b>{val.price}</b>;
                }
              })}
            </label>
          </h4>
          <h6>
            <label>
              <span>CardHolder Price : </span> <span>₹</span>
              {/* <b>{products.cardholderprice}</b> */}
              {products.map((val) => {
                if (val.configid === 1) {
                  return <b>{val.cardholderprice}</b>;
                }
              })}
            </label>
          </h6>
          <h6>
            <label>
              <span>Point Redeem : </span>
              {/* <b>{products.pointredm}</b> */}
              {/* <b>{products.productid}</b> */}
              {products.map((val) => {
                if (val.configid === 1) {
                  return <b>{val.pointredm}</b>;
                }
              })}
            </label>
          </h6>
          {/* <label>
            M.R.P: <del>₹1245</del>
          </label>
          <br /> */}
          <span>Inclusive of all taxes</span>
          <hr />

          <div>
            {products.map((val) => {
              if (val.configid <= 5) {
                return (
                  <>
                    <label>
                      <b>{val.configname} : </b>
                    </label>
                    <span> {val.configdtl}</span>
                    <br />
                  </>
                );
              }
            })}
            {/* <label>
              <b>Brand : </b>
            </label>
            <span>Pigeon by Stovekraft</span>
            <br />
            <label>
              <b>Capacity : </b>
            </label>
            <span> 1.5 litres</span>
            <br />
            <label>
              <b>Material : </b>
            </label>
            <span>Stainless Steel, Plastic</span>
            <br />
            <label>
              <b>Colour : </b>
            </label>
            <span>Black</span>
            <br />
            <label>
              <b>Voltage : </b>
            </label>
            <span> 240</span>
            <br />
            <label>
              <b>Product : </b>
            </label>
            <span>18.5L x 18.5W x</span>
            <br /> */}
          </div>

          <hr />
          <h5>About this item</h5>
          <p>
            {/* <b>{products.cardholderprice}</b> */}
            {/* <span>{products.productlongdesc}</span> */}
            {products.map((val) => {
              if (val.configid === 1) {
                return <span>{val.productlongdesc}</span>;
              }
            })}
          </p>
        </div>
        <div className="Thirdpart col-sm-3">
          <div className="border">
            <div>
              <h3>
                <span>₹</span>
                {/* <b>{products.price}</b> */}
                {products.map((val) => {
                  if (val.configid === 1) {
                    return <b>{val.price}</b>;
                  }
                })}
              </h3>
              <br />
              FREE delivery <b>Saturday, 31 December.</b> Details
              <br />
              Or fastest delivery <b>Tomorrow, December 30.</b> Order within 32
              mins. Details
              <br />
              Select delivery location
              <br />
              <big>
                <b>In stock.</b>
              </big>
              <br />
              Sold by RetailEZ Pvt Ltd and Fulfilled by Amazon.
              <br />
              <div class="row">
                <div class="col-md-5">Quantity:</div>
                <div class="col-md-6">
                  <select
                    class="form-select form-select-sm"
                    aria-label=".form-select-sm example">
                    <option selected>1</option>
                    <option value="1">2</option>
                    <option value="2">3</option>
                    <option value="3">4</option>
                  </select>
                </div>
              </div>
              <br />
              <center>
                <button className="btn btn-warning" onClick={method}>
                  Add To Cart
                </button>

                {/* <button
                  className="button button2"
                  onClick={handleClick}
                  disabled={isAdded}
                >
                  {isAdded ? "Added to Cart" : "Add To Cart"}
                </button> */}
                <br />
                <br />

                {/* {isLoggedIn ? (
                          <button
                            className="btn btn-primary btn-md mx-2"
                            onClick={handleLogout}
                          >
                            Logout
                          </button>
                        ) : (
                          <Button setModal1={setModal1} />
                        )}
                        {modal1 === true && (
                          <Modal1
                            setModal1={setModal1}
                            setIsLoggedIn={setIsLoggedIn}
                          />
                        )} */}

                <button class="btn btn-warning" onClick={handleLogout}>
                  Buy Now
                </button>
              </center>
            </div>
          </div>
        </div>
      </div>
      <div>
        <div class="row">
          <div class="col-md-6">
            <div className="table">
              <table>
                <thead>
                  <h3>Technical Details</h3>
                </thead>
                <tbody>
                  {products.map((val) => {
                    if (val.configid <= 8) {
                      return (
                        <>
                          <tr>
                            <th scope="row">{val.configname} : </th>
                            <td>{val.configdtl}</td>
                          </tr>
                        </>
                      );
                    }
                  })}
                </tbody>
              </table>
            </div>
          </div>
          <div class="col-md-6">
            <div className="table">
              <table>
                <thead>
                  <h3>Additional Information</h3>
                </thead>
                <tbody>
                  {products.map((val) => {
                    if (val.configid >= 8 && val.configid <= 16) {
                      return (
                        <>
                          <tr>
                            <th scope="row">{val.configname} : </th>
                            <td>{val.configdtl}</td>
                          </tr>
                        </>
                      );
                    }
                  })}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
