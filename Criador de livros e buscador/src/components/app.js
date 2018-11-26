import React from "react";
import React, { Component } from 'react';

import BookList from '../containers/book-list';
import BookDetail from '../cantainers/book-detail';


export default class App extends Component {
  render() {
    return (
      <div>
        <BookList />
        <BookDetail />
      </div>
    );
  }
}
