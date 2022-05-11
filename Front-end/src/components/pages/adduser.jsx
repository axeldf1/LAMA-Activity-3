import React, {Component, useState} from "react";
import {Link} from "react-router-dom";
import { Grid, Segment } from 'semantic-ui-react';
import {User} from '../user/containers/User';
import {UserShortDisplay} from "../user/components/UserShortDisplay";
import {UserForm} from "../userform/UserForm";


export const Adduser=()=>{
    const [currentUser,setCurrentUser]= useState({
        id:12,
        username:"John",
        lastname:"Doe",
        login:"jDoe",
        pwd:"jdoepwd",
        money:1000,
    });

    return (
        <div>
            <Segment>
                <UserForm>

                </UserForm>
            </Segment>

            <Link to={"/menu"}>Se Connecter</Link>
        </div>
    );
}
/*export default class index extends React.Component{
    render() {
        return(

        )
    }
}*/