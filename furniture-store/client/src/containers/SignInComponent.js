import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import { Button, Form } from "semantic-ui-react";
import { ToastContainer } from "react-toastify";
import { useDispatch } from 'react-redux';
import { getUser } from "../redux/actions/userActions";

import axios from "axios";

const SignInComponent = () => {

  let dispatch = useDispatch();
  const [values, setValues] = useState({
    email: "",
    password: ""

  })
  let { email, password } = values;
  const history = useHistory();

  const handleChange = (name) => (event) => {
    setValues({ ...values, [name]: event.target.value })
  }

  const handleSignInSubmit = async (event) => {
    event.preventDefault();
    setValues({ ...values });

    try {
      let response = await axios.get(`http://localhost:3004/users?email=${email}`)

      console.log(response.data)
      // dispatch(signInUser(response.data))
      let user = response.data[0];

      if (user && user.id && user.password == password) {
        dispatch(getUser(user))
        history.push(`/users/user`);
      } else {
        console.error("wrong credentials.");
        history.push(`/signup`);
      }

    } catch (e) {
      console.error(e)
    }
  }

  // useEffect(() => {

  // }, [])

  const signinForm = () => (
    <Form>


      <Form.Input
        onChange={handleChange("email")}
        value={email}
        label="Email"
        placeholder="joe@schmoe.com"
      />
      <Form.Input
        onChange={handleChange("password")}
        value={password}
        label="password"
        type="password"
        placeholder="password"
      />

      <Button onClick={handleSignInSubmit}> Sign In  </Button>
    </Form>
  );

  return (
    <div className="ui container" style={{ marginTop: "10em" }}>
      <ToastContainer />
      {signinForm()}
    </div>
  )
}

export default SignInComponent;