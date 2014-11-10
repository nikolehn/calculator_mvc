$(document).ready(function() {

    // State
    var dot_used = false;
    var stack_operation = null;
    var stack_operand = null;

    // Helpers
    function reset_input() {
        $('#input').text('');
        dot_used = false;
    }

    function reset_stack() {
        stack_operation = null;
        stack_operand = null;
    }

    function clear() {
        reset_input();
        reset_stack();
    }

    function flash_input() {
        $('#input').css('border-color', 'crimson');
        setInterval(function() {
            $('#input').css('border-color', 'white');
        }, 2000);
    }

    function add_history(line) {
        $('#history').append(line + '<br/>');
        var scroll = $('#history-scroll');
        var height = scroll[0].scrollHeight;
        scroll.scrollTop(height);
    }

    function call_server(operation, op1, op2) {

        var url = window.location.pathname + '/ops/' + operation;

        if (op1 !== null) {
            url = url + '/' + op1;
        }

        if (op2 !== null) {
            url = url + '/' + op2;
        }

        url = url + '/';

        var action = operation + '(';
        if (op1 !== null) {
            action = action + op1;
        }
        if (op2 !== null) {
            action = action + ', ' + op2;
        }
        action = action + ')';

        $.ajax({
            type: 'GET',
            /* dataType: 'json', */
            dataType: 'html',
            url: url,
            success: function(data) {
                add_history(action);
                clear();
                var result = $('<div />').append(data).find('#result').text();
                $('#input').text(result);
            },
            error: function(xhr, opts, err) {
                console.log(xhr.status);
                console.log(err);
                console.log(xhr.responseText);
                console.log(xhr);
                flash_input();
            }
        });
    }

    // Numbers
    $('button.num').click(function() {
        $('#input').append($(this).text());
    });

    // Zero operands operations
    $('button.op0').click(function() {

        var operation = $(this).attr('id');

        // Perfom call to server
        call_server(operation, null, null);
    });

    // One operand operations
    $('button.op1').click(function() {

        var operation = $(this).attr('id');
        var operand = $('#input').text();

        // Check the operand exists
        if (!operand) {
            flash_input();
            return;
        }

        // Perfom call to server
        call_server(operation, operand, null);
    });

    // Two operands operations
    $('button.op2').click(function() {

        var operation = $(this).attr('id');
        var operand = $('#input').text();

        // Check the operand exists
        if (!operand) {
            flash_input();
            return;
        }

        // Set first operand
        if (stack_operation === null) {
            stack_operation = operation;
            if (stack_operand === null) {
                stack_operand = operand;
                reset_input();
            }
            return;
        }

        // Check if the operation changed
        if (stack_operation !== operation) {
            stack_operation = operation;
            return;
        }

        // Perfom call to server
        call_server(operation, stack_operand, operand);
    });

    // Dot
    $('#dot').click(function() {
        if (!dot_used) {
            $('#input').append('.');
            dot_used = true;
        }
    });

    // Clear
    $('#clear').click(clear);

    // Equal
    $('#eq').click(function() {

        var operand = $('#input').text();

        if (!operand) {
            flash_input();
            return;
        }

        if (stack_operation !== null) {
            call_server(stack_operation, stack_operand, operand);
            return;
        }

        add_history(operand);
        reset_input();
    });
});