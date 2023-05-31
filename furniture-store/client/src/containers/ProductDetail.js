import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios';
import { removeSelectedProduct, selectedProduct } from '../redux/actions/productActions';
import { useDispatch, useSelector } from 'react-redux';
import { Button } from 'semantic-ui-react'
import MenuComponent from './Menu';
import { useHistory } from "react-router-dom";

const ProductDetail = () => {
  const { productId } = useParams();
  const product = useSelector(state => state.product)
  const user = useSelector(state => state.user)
  const cart = useSelector((state) => state.cart.cart)

  let { id: cartId, userId, productsOfCart } = cart;
  console.log(productsOfCart)
  // const { id : userId , email } = user;
  const { id: pdId, image, title, price, category, description } = product;

  let [quantity, setQuantity] = useState(1)
  const history = useHistory();

  const dispatch = useDispatch();

  const fetchProductDetail = async (id) => {
    try {
      const response = await axios.get(`http://localhost:3004/products/${id}`)
      console.log(response.data)
      dispatch(selectedProduct(response.data))
    } catch (error) {
      console.log(error)
    }
  }

  const handleAddCard = async (event) => {
    event.preventDefault();


    try {

      let toAddProducts = productsOfCart.map(x => x);
      let newProduct = {
        "id": pdId,
        "title": title,
        "price": price,
        "description": description,
        "category": "furniture",
        "quantity": quantity,
      }
      toAddProducts.push(newProduct)
      let toAddCart = {
        userId: userId,
        productsOfCart: toAddProducts
      }
      const response = await axios.patch(`http://localhost:3004/carts/${cartId}`, toAddCart)
      console.log(response)
      console.log("added to cart")
      history.push("/cart")
    } catch (e) {
      console.log(e)
    }
  }

  useEffect(() => {
    if (productId && productId !== "") {
      fetchProductDetail(productId)
    }
    return () => {
      dispatch(removeSelectedProduct())
    }
  }, [productId])

  // return (
  //   product && <div className="ui grid container">
  //     Hello
  //     {title} , {price}
  //   </div>
  // )
  return (
    <>
      <MenuComponent />

      <div className="ui grid container">

        {Object.keys(product).length === 0 ? (
          <div>...Loading</div>
        ) : (
          <div className="ui placeholder segment">
            <div className="ui two column stackable center aligned grid">
              <div className="ui vertical divider">AND</div>
              <div className="middle aligned row">
                <div className="column lp">
                  <img className="ui fluid image" src={image} />
                </div>
                <div className="column rp">
                  <h1>{title}</h1>
                  <h2>
                    <a className="ui teal tag label">${price}</a>
                  </h2>
                  <h3 className="ui brown block header">{category}</h3>
                  <p>{description}</p>
                  <p>Quantity : {quantity}</p>
                  <Button onClick={() => setQuantity(quantity + 1)}> + </Button>
                  <Button onClick={() => setQuantity(quantity - 1)}> - </Button>
                  <Button onClick={handleAddCard} >
                    <i className="shop icon"></i>
                    Add to Cart
                  </Button>
                  {/* <div className="ui vertical animated button" tabIndex="0">
                    <div className="hidden content">
                      
                    </div>

                    <div onClick={handleClick} className="visible content">Add to Cart</div>
                  </div> */}
                </div>
              </div>
            </div>
          </div>
        )}
      </div>
    </>

  );
}

export default ProductDetail;