<template>
  <div>
    <el-radio-group v-model="labelPosition" aria-label="label position">
      <el-radio-button value="left">Left</el-radio-button>
      <el-radio-button value="right">Right</el-radio-button>
      <el-radio-button value="top">Top</el-radio-button>
    </el-radio-group>
    <div style="margin: 20px" />
    <el-form
      :label-position="labelPosition"
      label-width="auto"
      :model="searchForm"
      style="max-width: 600px"
      @submit.prevent="handleSearch"
    >
      <el-form-item label="Name">
        <el-input v-model="searchForm.name" />
      </el-form-item>
      <el-form-item label="Address">
        <el-input v-model="searchForm.address" />
      </el-form-item>
      <el-form-item label="Date">
        <el-input v-model="searchForm.date" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleSearch">Search</el-button>
      </el-form-item>
    </el-form>
    
    <div class="switches">
      <span>Switch parent border: </span>
      <el-switch v-model="parentBorder" />
      <span>Switch child border: </span>
      <el-switch v-model="childBorder" />
    </div>

    <el-table
      ref="multipleTableRef"
      :data="paginatedData"
      height="400"
      style="width: 100%"
      :border="parentBorder"
      v-bind="$attrs"
      v-on="$listeners"
      @selection-change="handleSelectionChange"
      @sort-change="handleSortChange"
      class="custom-table"
    >
      <el-table-column type="selection" width="55" />
      <el-table-column type="expand">
        <template #default="props">
          <div m="4">
            <p m="t-0 b-2">State: {{ props.row.state }}</p>
            <p m="t-0 b-2">City: {{ props.row.city }}</p>
            <p m="t-0 b-2">Address: {{ props.row.address }}</p>
            <p m="t-0 b-2">Zip: {{ props.row.zip }}</p>
            <h3>Family</h3>
            <el-table :data="props.row.family" :border="childBorder">
              <el-table-column label="Name" prop="name" />
              <el-table-column label="State" prop="state" />
              <el-table-column label="City" prop="city" />
              <el-table-column label="Address" prop="address" />
              <el-table-column label="Zip" prop="zip" />
            </el-table>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        v-for="column in columns"
        :key="column.prop"
        :prop="column.prop"
        :label="column.label"
        :sortable="column.sortable"
        width="180"
        class="custom-table-column"
      >
        <template v-slot="scope">
          <slot :name="column.slot" v-bind="scope">{{ scope.row[column.prop] }}</slot>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="Operations" width="180" class="custom-table-operations">
        <template v-slot="scope">
          <el-button @click="handleEdit(scope.row)" class="edit-button">Edit</el-button>
          <el-button @click="handleDelete(scope.row)" class="delete-button">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      v-if="pagination"
      v-bind="pagination"
      @current-change="handlePageChange"
      :current-page.sync="pagination.currentPage"
      :page-size="pagination.pageSize"
      :total="filteredData.length"
    />

    <div style="margin-top: 20px">
      <el-button @click="toggleSelection([paginatedData[1], paginatedData[2]])">
        Toggle selection status of second and third rows
      </el-button>
      <el-button @click="toggleSelection()">Clear selection</el-button>
    </div>
  </div>
</template>

<script>
import { ref, reactive, computed, watch } from 'vue';
import { useRouter } from 'vue-router';

export default {
  name: 'CustomTable',
  props: {
    tableData: {
      type: Array,
      default: () => [],
    },
    columns: {
      type: Array,
      default: () => [],
    },
    pagination: {
      type: Object,
      default: () => ({
        currentPage: 1,
        pageSize: 10,
      }),
    },
  },
  setup(props, { emit }) {
    const router = useRouter();
    const parentBorder = ref(false);
    const childBorder = ref(false);
    const multipleTableRef = ref(null);
    const multipleSelection = ref([]);
    const labelPosition = ref('right');
    const searchForm = reactive({
      name: '',
      address: '',
      date: '',
    });

    const filteredData = computed(() => {
      if (!searchForm.name && !searchForm.address && !searchForm.date) {
        return props.tableData;
      }
      return props.tableData.filter((row) => {
        return (
          (!searchForm.name || row.name.includes(searchForm.name)) &&
          (!searchForm.address || row.address.includes(searchForm.address)) &&
          (!searchForm.date || row.date.includes(searchForm.date))
        );
      });
    });

    const paginatedData = computed(() => {
      const start = (props.pagination.currentPage - 1) * props.pagination.pageSize;
      const end = start + props.pagination.pageSize;
      return filteredData.value.slice(start, end);
    });

    watch(
      () => props.pagination.currentPage,
      (newPage) => {
        if (newPage > Math.ceil(filteredData.value.length / props.pagination.pageSize)) {
          props.pagination.currentPage = 1;
        }
      }
    );

    const handleSortChange = ({ prop, order }) => {
      emit('sort-change', { prop, order });
    };

    const handlePageChange = (page) => {
      props.pagination.currentPage = page;
    };

    const handleEdit = (row) => {
      emit('edit', row);
    };

    const handleDelete = (row) => {
      emit('delete', row);
    };

    const toggleSelection = (rows) => {
      if (rows) {
        rows.forEach((row) => {
          multipleTableRef.value.toggleRowSelection(row, undefined);
        });
      } else {
        multipleTableRef.value.clearSelection();
      }
    };

    const handleSelectionChange = (val) => {
      multipleSelection.value = val;
    };

    const handleSearch = () => {
      const query = { name: searchForm.name, address: searchForm.address, date: searchForm.date };
      router.push({ path: '/', query });
    };

    return {
      parentBorder,
      childBorder,
      filteredData,
      paginatedData,
      handleSortChange,
      handlePageChange,
      handleEdit,
      handleDelete,
      multipleTableRef,
      multipleSelection,
      toggleSelection,
      handleSelectionChange,
      labelPosition,
      searchForm,
      handleSearch,
    };
  },
};
</script>

<style scoped>
.toolbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

.custom-table {
  border: 1px solid #ebeef5;
  border-radius: 4px;
  overflow: hidden;
}

.custom-table-column .cell {
  background-color: #f5f7fa;
  font-weight: bold;
  color: #606266;
}

.custom-table-operations .cell {
  text-align: center;
}

.custom-table-column:nth-child(even) .cell {
  background-color: #fdfdfd;
}

.custom-table-column:nth-child(odd) .cell {
  background-color: #fcfcfc;
}

.edit-button {
  color: #409eff;
  border-color: #409eff;
}

.delete-button {
  color: #f56c6c;
  border-color: #f56c6c;
}

.el-pagination {
  margin-top: 20px;
  text-align: right;
}

.switches {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}
</style>
