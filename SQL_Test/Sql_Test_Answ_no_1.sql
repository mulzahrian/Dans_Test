with account_numbers as (
  select c.acc_number as acc_number from account a
  inner join customer c on (
    c.cust_id = a.acc_owner 
    and c.cust_firstname = 'John' 
    and c.cust_lastname = 'Michael')
)
select 
  t.trs_date as data, 
  t.trs_amount as amount, 
  case 
    when t.trs_type = 'DB' then 'Debit' 
    when t.trs_type = 'CR' then 'Credit'
    when t.trs_type = 'TF' then 'Transfer'
    else null
  end as "type",
  tt.trs_to_account as to_account,
  case 
    when tt.trs_status = 0 then 'Not Executed' 
    when tt.trs_status = 1 then 'Executed'
    when tt.trs_status = -1 then 'Failed'
    else null
  end as status
where from "transaction" t
left join transaction_transfer tt on (tt.trs_id = t.trs_id)
where t.trs_from_account in (select acc_number from account_numbers)
