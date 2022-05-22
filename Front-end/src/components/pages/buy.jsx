import React, {Component, useEffect, useState} from "react";
import {Card, Grid, Icon, Image, Segment} from 'semantic-ui-react';
import {Link} from "react-router-dom";
import {Header} from "./header";
import {ListCards} from "../list/container/list";
import {UserSimpleDisplay} from "../user/components/UserSimpleDisplay";
import axios from "axios";

export const Buy=(props)=>{
    const [currentUser, setCurrentUser] = useState({
        id: 12,
        username: "John",
        lastname: "Doe",
        login: "jDoe",
        pwd: "jdoepwd",
        money: 500,
        title: "Buy"
    });

    const fetchCurrentUser = async ()=>{
        const {data} = await axios.get('http://localhost:8080/users/3')
        const currentUser = data;
        setCurrentUser(currentUser)
        console.log(currentUser);
    }

    useEffect(() => {
        // fetchCurrentUser();

    }, []);

    return (
        <div>
            <Header title="Buy"/>
            <Grid divided='vertically'>
                <Grid.Row columns={2}>
                    <Grid.Column>

                        <Segment>
                            <ListCards action='Buy'></ListCards>
                        </Segment>

                    </Grid.Column>
                    <Grid.Column>

                        <Segment>
                            <UserSimpleDisplay title="Buy"></UserSimpleDisplay>
                            <Link to={"/menu"}>Menu</Link>
                        </Segment>

                    </Grid.Column>
                </Grid.Row>
            </Grid>
        </div>



    );
}
/*export default class index extends React.Component{
    render() {
        return(

        )
    }
}*/