import React from 'react';
import {  Component  } from 'react';

import BooList from '../containers/book-list';


export default class App extends Component {
    render() {
        return(
            <div>
                <BookList />
            </div>
        );
    }
}