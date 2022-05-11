import React, {Component, useState} from "react";
import {Card, Grid, GridColumn, Icon, Image, Segment} from 'semantic-ui-react';
import {Link} from "react-router-dom";
import {Header} from "./header";
import {ListCard} from "./list";

export const Menu=(props)=>{
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
            <Header title="Menu"/>
            <Grid divided='vertically'>
                <Grid.Row columns={2}>
                    <Grid.Column>

                        <Segment>
                            <Link to={"/buy"}>Buy</Link>
                        </Segment>

                    </Grid.Column>
                    <Grid.Column>

                        <Segment>
                            <Link to={"/sell"}>Sell</Link>
                        </Segment>

                    </Grid.Column>
                </Grid.Row>
            </Grid>
            <Link to={"/play"}>Play</Link>
        </div>
    );
}
/*export default class index extends React.Component{
    render() {
        return(

        )
    }
}*/