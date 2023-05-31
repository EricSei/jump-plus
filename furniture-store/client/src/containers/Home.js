import React from 'react'
import ProductListing from './ProductListing';
import Header from './Header';
import MenuComponent from './Menu';

const Home = () => {
  //display menu based off auth
  return <>
    {/* <Header /> */}
    <MenuComponent />
    <ProductListing />
    <div >
      Home
    </div>
  </>
}

export default Home;