import React from "react";
import "./cart.css";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'



const Cartpage = ({product_detail_Id,product_name,image_path,description,price,discount,quantity}) => {
    // const { id } = useParams();

    const handledelete = (product_detail_Id) => {
        alert(product_detail_Id);
        fetch("https://localhost:7144/api/AddToCarts/" + product_detail_Id, {
            method: 'Delete'
        })
            .then(res => res.json())
            .then((result) => {
                console.log(result);

            });
        // navigate('/');
    }
    
    return (
        <>
            {/* <h1 > Cart</h1>              
                <div className="cart-items">
                    <div className="cart-items-container">                       */}

            <div className="items-info">
                <div className="product-img">
                    <img src={image_path} alt="image error" />
                </div>

                <div className="title">
                    <h2>{product_name}</h2>
                    <p>{description}</p>
                </div>

                <div className="add-minus-quantity">
                    {/* <i className="fas fa-minus minus" >-</i> */}
                    <button type="button" class="btn btn-info"><h3>-</h3></button>
                    <input type="text" placeholder="quantity" />
                    <button type="button" class="btn btn-info"><h3>+</h3></button>
                    {/* <i className="fas fa-plus add" >+</i> */}
                </div>

                <div className="price">
                    <h3>{price}₹</h3>
                </div>
               
                <div className="remove-item">                 
                    {/* <img src="./images/delete.png" onClick={handledelete(props.id)} className="card-img-top" alt="image" width="30" height="30"/>   */}
                    {/* <button onClick={handledelete(product_detail_Id)}>
                        <img
                            src="./images/delete.png"
                            alt="Image"
                            width="30" height="30"
                        />                       
                    </button> */}

                    <input type="image" src="./images/delete.png"  
                             onClick={() => handledelete(product_detail_Id)}
                            alt="Image"
                            width="30" height="30" />
                </div>
            </div>
            <hr />
            {/* </div>
                </div>                         */}
        </>
    );
};

export default Cartpage;