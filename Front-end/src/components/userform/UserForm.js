import act, { useState } from 'react';
import { Form, Header,Button } from 'semantic-ui-react';
import { useDispatch } from 'react-redux';
import {updateUser,submitUser} from '../../actions';


export const UserForm = (props) =>{
    const dispatch = useDispatch();
    const [currentUser,setCurrentUser]= useState({
        username:"",
        password:"",
        re_password:""
    });

    function processInput(event, { valueData }){
        const target = event.currentTarget;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;
        console.log(event.target.value);
        let currentVal=currentUser;
        setCurrentUser({...currentUser, [name]: value});
        currentVal[name]= value;
        //props.handleChange(currentVal);
        dispatch(updateUser(currentVal));
    };

    function submitOrder(data){
        // props.submitUserHandler(data);
        dispatch(submitUser(currentUser));
    }

    return (
        <Form>
            <Header as='h4' dividing>
                User Registration
            </Header>
            <Form.Field>
                <Form.Input label="Username" placeholder="Username" onChange={processInput}  name="username" value={currentUser.username}/>
            </Form.Field>
            <Form.Field>
                <Form.Input type="password" label="Password" placeholder="" onChange={processInput}  name="pwd" value={currentUser.pwd}/>
            </Form.Field>
            <Form.Field>
                <Form.Input type="password" label="Re-Password" placeholder="" onChange={processInput}  name="re_password" value={currentUser.re_password}/>
            </Form.Field>
            <Form.Group widths="equal">
                <Button type='submit' href="/register" onClick={submitOrder}>S'enregistrer</Button>
                <Button type='submit' href="/login" onClick={submitOrder}>Connexion</Button>
            </Form.Group>

        </Form>

    );

}
