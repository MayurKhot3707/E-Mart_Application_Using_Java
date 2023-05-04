import React from "react";

export default function Carousel() {
  return (
    <div>
      <div
        id="carouselExampleControls"
        className="carousel slide"
        data-bs-ride="carousel">
        <div className="carousel-inner">
          <div className="carousel-item active">
            <img
              src="./images/Carouselimg1.jpg"
              className="d-block w-100"
              alt="caro-1"
            />
          </div>
          <div className="carousel-item">
            <img
              src="./images/Carouselimg2.jpg"
              className="d-block w-100"
              alt="caro-2"
            />
          </div>
          <div className="carousel-item">
            <img
              src="./images/Carouselimg3.jpg"
              className="d-block w-100"
              alt="caro-3"
            />
          </div>
        </div>
        <button
          className="carousel-control-prev"
          type="button"
          data-bs-target="#carouselExampleControls"
          data-bs-slide="prev">
          <span
            className="carousel-control-prev-icon"
            aria-hidden="true"></span>
          <span className="visually-hidden">Previous</span>
        </button>
        <button
          className="carousel-control-next"
          type="button"
          data-bs-target="#carouselExampleControls"
          data-bs-slide="next">
          <span
            className="carousel-control-next-icon"
            aria-hidden="true"></span>
          <span className="visually-hidden">Next</span>
        </button>
      </div>
    </div>
  );
}
