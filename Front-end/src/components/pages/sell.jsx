import React, {Component, useState} from "react";
import {Card, Grid, Icon, Image, Segment} from 'semantic-ui-react';
import {Link} from "react-router-dom";
import {Header} from "./header";
import {UserSimpleDisplay} from "../user/components/UserSimpleDisplay";
import {ListSellDisplay} from "../list/components/ListSellDisplay";

export const Sell=(props)=>{

    return (
        <div>
            <Header title="Sell"/>
            <Grid divided='vertically'>
                <Grid.Row columns={2}>
                    <Grid.Column>

                        <Segment>
                            <ListSellDisplay action="Sell"></ListSellDisplay>
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