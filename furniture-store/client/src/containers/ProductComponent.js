import React from 'react'
import { render } from 'react-dom';
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom/cjs/react-router-dom.min';

const ProductCompnent = () => {
  const products = useSelector((state) => state.allProducts.products);
  // const { id, title } = products[0];
  const renderList = products.map(product => {
    const { id, title, image, price, category } = product;
    return (
      <div className='three column wide' key={id}>
        <Link to={`/products/${id}`}>
          <div className='ui link cards' >
            <div className='card'>
              <div className='image'>
                <img src={image} alt={title}>
                </img>
              </div>
              <div className='content'>
                <div className='header' >
                  {title}
                </div>
                <div className='meta price' >
                  $ {price}
                </div>
                <div className='meta'>
                  {category}
                </div>
              </div>
            </div>
          </div>
        </Link>
      </div>
    )
  })

  return (
    <>{renderList}</>
  )
}

export default ProductCompnent;