import act, { useState } from 'react';
import { Form, Header,Button } from 'semantic-ui-react';
import { useDispatch } from 'react-redux';
import { useNavigate } from "react-router-dom";
import {updateUser} from '../../actions';


export const UserLogin = (props) =>{

    const [auth__content,SetAuth_content]= useState({value: '', pass: ''})


    const [currentUser,setCurrentUser]= useState({
        id:5,
        name:"",
        surname:"",
        balance:0
    });
    const dispatch = useDispatch();
    const navigate = useNavigate();

    function handleChange(ev) {
        const target = ev.currentTarget;
        const value = target.value;
        const name = target.name;
        SetAuth_content({...auth__content, [name]: value })

    }

    function handleSubmit(ev) {
        ev.preventDefault();

        if (auth__content.value == 'admin' && auth__content.pass == 'admin') {
            setCurrentUser({currentUser, id: 1, name: 'admin', surname:"superadmin", balance:100});
            // system.out.print("Current id=", currentUser.id.toString())
            dispatch(updateUser(currentUser));
            navigate("/menu")
        }
    }

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Field>
                <label>Pseudo</label>
                <input placeholder='Your pseudo' value={auth__content.value} name="value" onChange={handleChange} />
            </Form.Field>
            <Form.Field>
                <label>Password</label>
                <input type="password" placeholder='Your password' value={auth__content.pass}  name="pass" onChange={handleChange} />
            </Form.Field>
            <Button type='submit'>Connect</Button>
        </Form>
    );

}
