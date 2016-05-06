import React from 'react';
import { Button } from 'react-bootstrap';
import { Table } from 'react-bootstrap';

const XTable = React.createClass({
    propTypes: {
        ajaxMethod: React.PropTypes.string
    },

    getDefaultProps() {
        return {
            ajaxMethod: 'ajax/queryData'
        };
    },

    getInitialState() {
        return {
            data : {
                columns : [],
                rows : []
            }
        };
    },


    componentWillMount: function() {
        $.get(this.props.ajaxMethod, function(result) {
            this.setState({
                data : {
                    rows :    result.rows,
                    columns : result.columns
                }
            });

        }.bind(this));
    },


    render() {
        return (
            <div>
            <Table  striped bordered condensed hover>
                <thead>
                <tr>
                    {
                        this.state.data.columns.map(
                            function(column){
                                return <th>{column}</th>;
                            }
                        )
                    }
                    <th>#</th>
                </tr>
            </thead>
                <tbody>
                {
                    this.state.data.rows.map(
                        function(row){
                            return (
                                <tr>
                                    {
                                        row.map(
                                            function(data){
                                                return <td>{data}</td>
                                            }
                                        )
                                    }
                                </tr>);
                        }
                    )
                }
                <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                </tbody></Table>
        </div>
        );
    }
});

export default XTable