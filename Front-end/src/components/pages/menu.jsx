import React, {Component, useState} from "react";
import {Card, Grid, GridColumn, Icon, Image, Segment} from 'semantic-ui-react';
import {Link} from "react-router-dom";
import {Header} from "./header";
import {useSelector} from "react-redux";
import {Login} from "./login";

export const Menu=(props)=>{
    let current_user = useSelector(state => state.userReducer.user);

    console.log("Current user =",current_user.id.toString())
    if (typeof current_user.id === 'undefined'){
        return <Login></Login>
    }
    else return (
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
