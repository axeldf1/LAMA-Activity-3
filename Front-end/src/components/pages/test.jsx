import React, {Component, useState} from "react";
import {Card, Grid, Icon, Image, Segment} from 'semantic-ui-react';
import {Link} from "react-router-dom";
import {Header} from "./header";
import ListCard from "./list";
import axios from "axios";


export class Test extends Component {
    state = {
        card: []
    }

    componentDidMount() {
        axios.get('http://localhost:8080/cards/3'
        ).then((response) => {
            const card = response.data;
            console.log(card)
            setTimeout(()=>{
                this.setState({card})
            },1500)
        })
    }

    render() {
        return (
            <div className="Test">
                <h1>Ma carte : {(this.state.card.name) ? this.state.card.name : <p>Chargement...</p>}</h1>
            </div>
        )
    }


}

/*export default class index extends React.Component{
    render() {
        return(

        )
    }
}*/