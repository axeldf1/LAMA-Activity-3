import React, {Component, useEffect, useState} from "react";
import {Card, Grid, Icon, Image, Segment} from 'semantic-ui-react';
import {Link} from "react-router-dom";
import {Header} from "./header";
import {UserSimpleDisplay} from "../user/components/UserSimpleDisplay";
import axios from "axios";
import {ListBuyDisplay} from "../list/components/ListBuyDisplay";
import {useSelector} from "react-redux";

export const Buy=(props)=>{
    let current_user = useSelector(state => state.userReducer.user);


    return (
        <div>
            <Header title="Buy"/>
            <Grid divided='vertically'>
                <Grid.Row columns={2}>
                    <Grid.Column>

                        <Segment>
                            <ListBuyDisplay action='Buy'></ListBuyDisplay>
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