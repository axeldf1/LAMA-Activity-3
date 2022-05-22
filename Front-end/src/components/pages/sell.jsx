import React, {Component, useState} from "react";
import {Card, Grid, Icon, Image, Segment} from 'semantic-ui-react';
import {Link} from "react-router-dom";
import {Header} from "./header";
import {ListCards} from "../list/container/list";
import {UserSimpleDisplay} from "../user/components/UserSimpleDisplay";

export const Sell=(props)=>{
    const [currentUser, setCurrentUser] = useState({
        id: 12,
        username: "John",
        lastname: "Doe",
        login: "jDoe",
        pwd: "jdoepwd",
        money: 500,
        title: "Sell"
    });

    return (
        <div>
            <Header title="Sell"/>
            <Grid divided='vertically'>
                <Grid.Row columns={2}>
                    <Grid.Column>

                        <Segment>
                            <ListCards action="Sell"></ListCards>
                        </Segment>

                    </Grid.Column>
                    <Grid.Column>

                        <Segment>
                            <UserSimpleDisplay title="Sell"></UserSimpleDisplay>
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