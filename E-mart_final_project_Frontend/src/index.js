import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { SecondPage } from "./SmallComponent/Secondpage";
import DescPage from "./SmallComponent/DescPage";
import Footer from "./Component/Footer";
import Navbar from "./Component/Navbar";
import InsertToCart from "./SmallComponent/InsertToCart";
import AddToCart from "./Pages/AddToCart";
import Order from "./Pages/Order";
import Payment from "./Pages/Payment";
import OrderInvoice from "./Pages/OrderInvoice";
import Checkout from "./Pages/Checkout";
import Searchnew from "./Component/Searchnew";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<App />} />

        {/* <Route path='Getlist' element={<Getlist/>}/> */}

        <Route path="/AddToCart" element={<AddToCart />} />
        <Route path="/Order" element={<Order />} />
        <Route path="/Checkout" element={<Checkout />} />
        <Route path="/Secondpage/:catMasterID" element={<SecondPage />} />
        <Route path="/DescPage/:productID" element={<DescPage />} />
        <Route path="/InsertToCart/:productId" element={<InsertToCart />} />
        <Route path="/Searchnew/:productname" element={<Searchnew />} />
        <Route path="/Payment" element={<Payment />} />
        <Route path="/OrderInvoice" element={<OrderInvoice />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
