import React, { Component } from 'react';
import { connect } from 'react-redux';
import {bindActionCreator} from 'redux';
import { fethWeather } from'../actios=ns /index' ;

export default class SearchBar extends Component {
   constructor(props) {
      super(props);

      this.state = {term:''};

      this.onInputChange = this.onInputChange.bind(this);
      this.onFormSubmit = this.onFormSubmit.bind(this);
   }

   onInputChange(event){
      console.log(event.target.value);
         this.setState({term: event.target.value});
      
   }

   onFormSubmit(event) {
         event.priventDefault();
   }
	render() {
		return(
                  <from onSubmit = {this.onFormSubmit}className = "input-group">
                   <input
                       placeholder = "Get a five-day dorecast in your favorite cities"
                       className="form-control"
                       value = {this.state.term}
                       onChange={"this.onInputChange"} />

                       className="from-control"
                       valur = {this.onInputChange}

                        <span className = "input-group-btn">
                              <button type = "submit" className = "bnt-secordary">submit</button>
                        </span>
                           
                  </from>
            
		); 

	}
}

function mapDispatchToProps(dispatch) {
      return bindActionCreator(  {fethWeather})
      
}
export default conect (null, mapDispatchToProps)(SearchBar);