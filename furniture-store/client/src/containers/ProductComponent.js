import React from 'react'
import { render } from 'react-dom';
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom/cjs/react-router-dom.min';
import { Grid, Image, List, Card } from 'semantic-ui-react'


const ProductCompnent = () => {
  const products = useSelector((state) => state.allProducts.products);
  // const { id, title } = products[0];


  const renderList = products.map(product => {
    const { id, title, image, price, category } = product;
    return (
      <Grid.Column key={id}>
        <Link to={`/products/${id}`}>
          <Card>
            <Image src={image} size="small" />
            <Card.Content>
              <Card.Header>  Title: {title} </Card.Header>
              <Card.Meta> Price:  {price} </Card.Meta>
              <Card.Description>  Category: {category} </Card.Description>
            </Card.Content>
          </Card>
        </Link>
      </Grid.Column>
    )
  })

  return (
    <>{renderList}</>
  )
}

export default ProductCompnent;


{/* <div className='three column wide divided' key={id}>
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
</div> */}