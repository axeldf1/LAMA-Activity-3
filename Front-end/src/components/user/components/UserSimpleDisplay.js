import React from 'react';
import {Button, Card, Icon, Image} from 'semantic-ui-react';

export const UserSimpleDisplay=(props) =>{
    return (
        <Card>
            <Image src='https://www.nicepng.com/png/full/982-9820051_heart-2352306885-deadpool-png.png' wrapped ui={false} />
            <Card.Content>
                <Card.Header>{props.username}</Card.Header>
                <Card.Meta>
                    <span className='date'>login: {props.login}</span>
                </Card.Meta>
                <Card.Description>
                    User In DataBase
                </Card.Description>
            </Card.Content>
            <Card.Content extra>
                <a>
                    <Icon name='money bill alternate outline' />
                    {props.money} $
                </a>
            </Card.Content>
            <Button type='submit' href="/menu">{props.title}</Button>
        </Card>

    );
}
