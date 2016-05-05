import ReactDOM from 'react-dom';
import React from 'react';
import BTable from '../component/BTable'
//import Button from 'react-bootstrap/lib/Button';
//// or
import { Button } from 'react-bootstrap';

ReactDOM.render(<div>

        <Button bsStyle="primary" bsSize="large">Large button</Button>
    <BTable></BTable>
    </div>


    ,document.getElementById('react-content'));