import React, {Component } from 'react';
import { connect } from 'react-redux';
import { selectBook } from "../action/index";
import { bindActionCreators } from 'redux';

class BookList extends Component {
    renderList() {
        return this.props.books.map((book) => {
            return(
                <li key={book.title}
                onClick={() => this.props.selectBook(book)}
                className = "list_group-item">{book.title}

                </li>
            );
       }
       return this.props.books.map((book) =>  {
             return(
                <li key={book.title} className = "list_group-item">{book.title}"> 
                </li>
            );
        }
           
      
    
        render() 
            return (
                this.newMethod()
            )
                
            
        };
        
    

    newMethod() {
        return <ul className="list-group col-sm-4"> {this.renderList()}</ul>;
    }
}

function mapStateToProps(state) {
    //Whatever is returned will show up as  props
    // inside of bookList
    return {
       books: state.books
    };
    
    }

    //Anythig returned from this function will end up as props
    //on the BookList container
    function mapDispactProps(dispatch){
       //Whenever selectBook is calld, the redult shoudl be passed
       // to all of our reducers
        return   bindActionCreators({ selectBook}, dispatch);
}

//Promote BookList from a component  to a container = i needs to know
//about this new dispach method, selectBokk.Make it available
//as a prop.
export default connect(mapStateToProps)(BookList); 