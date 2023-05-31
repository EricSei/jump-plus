import React, { useState } from "react";
import { Link, useHistory } from "react-router-dom";
import { Button, Form, Checkbox } from "semantic-ui-react";
import { ToastContainer, toast } from "react-toastify";
import { useDispatch } from 'react-redux';
import axios from "axios";

const SignUpComponent = () => {

  let dispatch = useDispatch();
  const [values, setValues] = useState({
    name: "",
    email: "",
    password: "",
    role: "user",
  })
  let { name, email, password, role } = values;
  const history = useHistory();

  const handleChange = (name) => (event) => {
    setValues({ ...values, [name]: event.target.value })
  }

  const clickSubmit = async (event) => {
    event.preventDefault();
    setValues({ ...values, role: "user" });

    try {
      let response = await axios.post(`http://localhost:3004/users`, { name, email, password })
      toast.success(response.data.message);
      console.log(response.data)
      // dispatch(signUpUser(response.data))
      history.push(`/users/user/${response.data.id}`);
    } catch (e) {
      console.error(e)
    }
  }

  // useEffect(() => {

  // }, [])

  const signupForm = () => (
    <Form>
      <Form.Input
        onChange={handleChange("name")}
        value={name}
        label="Name"
        placeholder="joe smith"
      />

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
      <Form.Field>
        <Checkbox
          label="I agree to the Terms and Conditions. "
          defaultChecked={true}
        />
        <Link to="/terms"> Read More</Link>
      </Form.Field>

      <Button onClick={clickSubmit}> Register </Button>
    </Form>
  );

  return (
    <div className="ui container" style={{ marginTop: "10em" }}>
      <ToastContainer />
      {signupForm()}
    </div>
  )
}

export default SignUpComponent;